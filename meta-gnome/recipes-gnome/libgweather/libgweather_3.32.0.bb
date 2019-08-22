SUMMARY = "Location and timezone database and weather lookup library"
HOMEPAGE = "https://wiki.gnome.org/Projects/LibGWeather"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI[archive.md5sum] = "68f28c2abb89ed2182aea6752d685cc6"
SRC_URI[archive.sha256sum] = "de9a2b392a8b27e012ed80bb9c950085692cd8e898c367c092df15f964a91d13"

DEPENDS = "gtk+3 libxml2 libsoup-2.4 glib-2.0 itstool-native geocode-glib glib-2.0-native"

WARN_QA_remove = "unknown-configure-option"

FILES_${PN} += "${datadir}/glib-2.0/schemas"

GNOMEBASEBUILDCLASS = "meson"
inherit gnomebase gobject-introspection gettext
FILES_${PN} += "${datadir}/icons"

EXTRA_OEMESON = "--buildtype=release -Denable-introspection=true"

