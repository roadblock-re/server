# 🚧 Roadblock

Server implementation for a known mobile racing game.

Multiuser or multiplayer are not implemented yet.

Server code is licensed under AGPL. Please, respect that and publish your code changes.

## Compatibility

* 🟢 - great network compatibility
* 🟡 - game starts and goes past tutorial
* 🔴 - not working

| Game version   | Status |
|----------------|--------|
| 47.1.0         | 🟢     |
| 45.0.x         | 🟡     |
| 24.6.x         | 🟡     |
| 24.0.x         | 🟡     |
| 3.9.x          | 🟢     |
| 3.8.x          | 🟡     |
| 3.7.x          | 🟡     |
| 3.6.x          | 🟡     |
| Other versions | 🔴     |

More versions may be supported in the future.

# How to set up

* Install JRE 17 if you haven't already.
* Launch server once (`./gradlew :run`).
* Install certificate from `certs` directory as a trusted root CA.
* Add alias for `eve.gameloft.com` in hosts file.
* Enjoy.

# Known errors

* `2-0-0-0-*` - game can't access HTTP backend.
* `2-0-6-0`, `2-0-6-1`, `2-0-6-3` - issue related to Steam API.
* `1-3-1` - game can't verify SSL certificate.
* `1-3-5` - game can't deserialize login response correctly.