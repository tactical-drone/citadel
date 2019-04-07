LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=625f055f41728f84a8d7938acc35bdc2"

SRC_URI[archive.md5sum] = "0a618c5b053106d1801d89cc77385419"
SRC_URI[archive.sha256sum] = "58f539b0386f36300b76f3afea3a508de4914b27e78f58ee4d142486a42f926a"
DEPENDS = "glib-2.0 exiv2"

GNOMEBASEBUILDCLASS = "meson"
inherit gnomebase python3native gobject-introspection

EXTRA_OEMESON = "-Dvapi=false"

