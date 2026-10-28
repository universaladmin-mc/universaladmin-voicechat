# Changelog

Format follows [Keep a Changelog](https://keepachangelog.com/). Versions up
to 1.5.0 were released together with UniversalAdmin from its repository -
see [its changelog](https://github.com/universaladmin-mc/UniversalAdmin/blob/main/CHANGELOG.md).

## [1.6.1] - 2026-10-28

### Fixed

- The check for a new enough UniversalAdmin compared against the version the
  extension was built with, not the one that runs - on an older
  UniversalAdmin it started anyway and failed later. It now reads the
  running version.

## [1.6.0] - 2026-10-28

### Changed

- Its own repository in the `universaladmin-mc` organization, released on
  its own.
- UniversalAdmin's update check covers it (UniversalAdmin 1.6 or newer): new
  versions are announced and, with `update.auto-download`, downloaded on
  their own.
- New icon.
