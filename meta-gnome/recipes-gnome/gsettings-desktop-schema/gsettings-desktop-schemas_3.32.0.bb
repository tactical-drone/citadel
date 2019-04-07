SUMMARY = "GNOME desktop-wide GSettings schemas"
HOMEPAGE = "http://live.gnome.org/gsettings-desktop-schemas"
BUGTRACKER = "https://bugzilla.gnome.org/"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

DEPENDS = "glib-2.0 intltool-native"

GNOMEBASEBUILDCLASS = "meson"
inherit gnomebase gsettings gettext gobject-introspection upstream-version-is-even

EXTRA_OEMESON = "-Dintrospection=true"

SRC_URI = "${GNOME_MIRROR}/${GNOMEBN}/${@gnome_verdir("${PV}")}/${GNOMEBN}-${PV}.tar.${GNOME_COMPRESS_TYPE};name=archive \
           file://0001-remove-cross-compile-check.patch \
           "
SRC_URI[archive.md5sum] = "0c2d468a482c12594757442c983aa8ea"
SRC_URI[archive.sha256sum] = "2d59b4b3a548859dfae46314ee4666787a00d5c82db382e97df7aa9d0e310a35"
