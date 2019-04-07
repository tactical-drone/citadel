SUMMARY = "Bluetooth integration with GNOME desktop"
HOMEPAGE = "https://wiki.gnome.org/Projects/GnomeBluetooth"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a \
                    file://COPYING.LIB;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI[archive.md5sum] = "e6c0e5fafa6a2673a3f102b1683c61d6"
SRC_URI[archive.sha256sum] = "ab8fa07613aa6b92be6151b1e2063cad5349bc1a8314eb091a0e62be2ea03e52"


DEPENDS = "glib-2.0 glib-2.0-native gtk+3 libcanberra libnotify libxml2-native gobject-introspection"

GNOMEBASEBUILDCLASS = "meson"
inherit gnomebase gobject-introspection gettext
FILES_${PN} += "${datadir}/icons"

EXTRA_OEMESON = "--buildtype=release -Denable-introspection=true"

