SUMMARY = "Default GNOME desktop background images"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=75859989545e37968a99b631ef42722e"

SRC_URI[archive.md5sum] = "a13411df9de5255a3a702ec2dfaa5ca8"
SRC_URI[archive.sha256sum] = "21fc5879ec1a5f592d383d3f9b407a2d58274c25fc8277a9e1c4a10642118a95"

FILES_${PN} += "\
    ${datadir}/backgrounds/gnome \
    ${datadir}/gnome-background-properties \
"

GNOMEBASEBUILDCLASS = "meson"
inherit gnomebase gettext
