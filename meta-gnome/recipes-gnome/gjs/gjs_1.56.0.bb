SUMMARY = "GNOME javascript bindings based on the Spidermonkey javascript engine"
HOMEPAGE = "https://wiki.gnome.org/Projects/Gjs"

LICENSE = "MIT & LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=beb29cf17fabe736f0639b09ee6e76fa \
                    file://COPYING.LGPL;md5=3bf50002aefd002f49e7bb854063f7e7"

inherit gnomebase gettext gobject-introspection

export GI_DATADIR="${STAGING_DATADIR}/gobject-introspection-1.0"

DEPENDS = "glib-2.0 gobject-introspection cairo gtk+3 mozjs glib-2.0-native"
EXTRA_OECONF = "--without-dbus-tests"

SRC_URI[archive.md5sum] = "aa47ee8bdcb7c36e9eafd4c7796fbb96"
SRC_URI[archive.sha256sum] = "64a7ad5554adb0105fabb432abcfa690033c177d8e650872b469b7cbf475ec1a"

RDEPENDS_${PN} += "libmozjs"

FILES_${PN}-dbg += "${datadir}/gjs-1.0/lsan ${datadir}/gjs-1.0/valgrind"
