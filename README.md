<img src="assets/icon.png" alt="UniversalAdmin Voice Chat" width="96" align="right">

# UniversalAdmin Voice Chat

[![Build](https://github.com/universaladmin-mc/universaladmin-voicechat/actions/workflows/build.yml/badge.svg)](https://github.com/universaladmin-mc/universaladmin-voicechat/actions/workflows/build.yml)
[![License](https://img.shields.io/badge/license-GPL--3.0-blue.svg)](LICENSE)
[![Modrinth](https://img.shields.io/badge/Modrinth-universaladmin-voicechat-00AF5C)](https://modrinth.com/plugin/universaladmin-voicechat)

Simple Voice Chat for UniversalAdmin: mute in the chat, in the voice chat or both, silent vanish, voice status on the profile and a staff voice group.

An official extension for [UniversalAdmin](https://github.com/universaladmin-mc/UniversalAdmin),
the free all-in-one admin plugin for Paper.

- **Documentation:** [https://universaladmin-mc.github.io/UniversalAdmin/extensions/voicechat/](https://universaladmin-mc.github.io/UniversalAdmin/extensions/voicechat/)
- **Download:** [Modrinth](https://modrinth.com/plugin/universaladmin-voicechat) or the
  [releases](https://github.com/universaladmin-mc/universaladmin-voicechat/releases) - put the
  jar next to UniversalAdmin in `plugins/`. UniversalAdmin's update check
  covers this extension too.
- **Bugs and ideas:** [UniversalAdmin's issues](https://github.com/universaladmin-mc/UniversalAdmin/issues)

## Building

```bash
./gradlew build   # build/libs/universaladmin-voicechat-<version>.jar
```

It compiles against the UniversalAdmin release named in `gradle.properties`
(from Modrinth's Maven repository); `-PuniversaladminJar=<path>` builds
against a local UniversalAdmin build instead. Releases: bump `version` in
`build.gradle.kts`, add a `CHANGELOG.md` section, tag `v<version>` - the
release workflow publishes to GitHub and Modrinth.

## License

[GNU GPL v3.0 or later](LICENSE).
