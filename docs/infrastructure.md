# Infrastructure

- Code hosted on Github
- CI/CD via Github Actions
- App and database hosted using [dokku](https://dokku.com/docs/) on a [Hostinger VPS](https://hpanel.hostinger.com/)

## Dokku Configuration

Basic reference: [Hostinger guide](https://support.hostinger.com/en/articles/10100263-how-to-use-the-dokku-vps-template)

On VPS
- Configure global domain for deployments:

```shell
dokku domains:set-global ohdyno.app
```

- Enable SSL ([Dokku Doc](https://dokku.com/docs/deployment/application-deployment/?h=letsencrypt#setting-up-ssl))

```shell
dokku plugin:install https://github.com/dokku/dokku-letsencrypt.git
dokku letsencrypt:set --global email xing@ohdyno.app
dokku letsencrypt:cron-job --add
dokku letsencrypt:enable workout # after deploying
```

On Local Machine:
- Add SSH public key to Dokku to support deploying from Github

```shell
cat ~/.ssh/<key>.pub | ssh root@ohdyno.app dokku ssh-keys:add gh
```

## Deployment Configurations

Because the project include a plugin to set up git hooks, the project fails when
it builds on Dokku since Dokku does not clone the full repository. A maven profile "no-git" is set up
to disable the plugin. To execute maven commands using this profile, configure the following environment variable in
Dokku:

```shell
dokku config:set workout MAVEN_CUSTOM_OPTS='-DskipTests -Pno-git'
```

