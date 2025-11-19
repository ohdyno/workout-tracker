# Infrastructure

- Code hosted on Github
- CI/CD via Github Actions
- App and database hosted using [dokku](https://dokku.com/docs/) on a [Hostinger VPS](https://hpanel.hostinger.com/)
- Domain is registered on [Namecheap](https://www.namecheap.com/)
- DNS is configured via [Hostinger](https://hpanel.hostinger.com/domains)

## Hostinger VPS Setup

### Basic Security

1. Create a non-root user
```shell
# on VPS as root
adduser <user_name> # add user
usermod --append --groups sudo <user_name> # grant super user privileges to user
su - <user_name> # verify that the user is created correctly
```

2. Enable login using SSH keys instead of password. [Resource](https://www.hostinger.com/tutorials/vps-security)
```shell
# local machine
ssh-copy-id -f -i ~/.ssh/dokku.pub <user_name>@ohdyno.app # add public key to authorized_keys on the host
ssh <user_name>@ohdyno.app # verify that the ssh uses keys instead of password 
```

3. Disable root login through SSH. [Resource](https://www.hostinger.com/tutorials/vps-security)
```shell
# on VPS as <user_name>
sudo vi /etc/ssh/sshd_config # and add/replace the line with PermitRootLogin=no
```
```shell
# on local machine
ssh root@ohdyno.app # verify that root cannot login
```

4. Change default SSH port. [Resource](https://www.hostinger.com/tutorials/vps-security)
```shell
# on VPS as <user_name>
sudo vi /etc/ssh/sshd_config # and replace Port 22 with some other <port_number>
```
```shell
# on local machine
ssh -p <port_number> <user_name>@ohdyno.app # verify that the new port is setup correctly
```

### Nice-to-have Tools on VPS

```shell
# on VPS as <user_name>
sudo apt install tree bat fzf fd-find ripgrep fish btop
sudo snap install helix --classic
```

## Dokku Configuration

To make it easier to configure dokku, add SSH public key to `dokku` user:

```shell
# on local machine
# assume on macOS and the password for <user_name> is on the clipboard
 echo "\
 $(pbpaste)
 $(cat ~/.ssh/dokku.pub)
 " | ssh -p <port_number> <user_name>@ohdyno.app sudo -S dokku ssh-keys:add gh
```

Now, to verify that the key was added correctly ADN that dokku commands can be run through SSH:

```shell
# on local machine
ssh -p <port_number> dokku@ohdyno.app ssh-keys:list
# should return something like the following
# SHA256:<id> NAME="gh" SSHCOMMAND_ALLOWED_KEYS="no-agent-forwarding,no-user-rc,no-X11-forwarding,no-port-forwarding"
```

If successful, then the following commands can be run on the local machine with the alias:

```shell
alias dokku ssh -p <port_number> dokku@ohdyno.app
```

or for fish shell:

```shell

function dokku --description 'Execute remote dokku commands'
    ssh -p <port_number> dokku@ohdyno.app $argv
end
```

On VPS
- Configure global domain for deployments:

```shell
# on local machine with proper alias
dokku domains:set-global ohdyno.app # configure global domain
# enable SSL
dokku plugin:install https://github.com/dokku/dokku-letsencrypt.git
dokku letsencrypt:set --global email xing@ohdyno.app
dokku letsencrypt:cron-job --add
dokku letsencrypt:enable workout # after deploying
```

Resources:
- [SSL Configuration](https://dokku.com/docs/deployment/application-deployment/?h=letsencrypt#setting-up-ssl)

## Deployment Configurations

Once Dokku is configured with the proper SSH key, then deployment is as simple as pushing to dokku as a git remote:

```shell
# local machine
git remote add dokku dokku@ohdyno.app:workout
git push dokku main
```

### Project Specific Deployment Configurations

Because the project include a plugin to set up git hooks, the project fails when
it builds on Dokku since Dokku does not clone the full repository. A maven profile "no-git" is set up
to disable the plugin. To execute maven commands using this profile, configure the following environment variable in
Dokku:

```shell
dokku config:set workout MAVEN_CUSTOM_OPTS='-DskipTests -Pno-git'
```