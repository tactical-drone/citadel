SUMMARY = "configuation database system"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"
SECTION = "x11/gnome"

SRC_URI[archive.md5sum] = "e1ac0b6285abefeed69ca9e380e44f5a"
SRC_URI[archive.sha256sum] = "68bce78b19bc94cb2c3bb8587e37f9e5e338568c3a674f86edde9c9f1624ffab"

DEPENDS = "dbus glib-2.0 xmlto-native glib-2.0-native"

GNOMEBASEBUILDCLASS = "meson"

inherit gnomebase bash-completion vala

SRC_URI += "file://0001-meson.build-do-not-compile-docs.patch"

FILES_${PN} += " \
    ${datadir}/dbus-1 \
    ${libdir}/gio/modules/*.so \
"

EXTRA_OEMESON_append_class-native = "-Dbash_completion=false"

BBCLASSEXTEND= "native"
