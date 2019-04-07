SUMMARY = "Virtual terminal emulator GTK+ widget library"
BUGTRACKER = "https://bugzilla.gnome.org/buglist.cgi?product=vte"
LICENSE = "LGPLv2.1+"
DEPENDS = "glib-2.0 gtk+3 libpcre2 intltool-native libxml2-native gperf-native gnutls"

LIC_FILES_CHKSUM = "file://COPYING.GPL3;md5=2f31b266d3440dd7ee50f92cf67d8e6c"

inherit gnomebase gtk-doc distro_features_check upstream-version-is-even gobject-introspection vala

SRC_URI[archive.md5sum] = "67d3c07cfd59bfe1872a95dcc22feeff"
SRC_URI[archive.sha256sum] = "5fab50e66b9d5bb7dfc6a1a9c334ed10d60b63f4a222f11281bba977ae11b7f0"

ANY_OF_DISTRO_FEATURES = "${GTK3DISTROFEATURES}"

# Help g-ir-scanner find the .so for linking
do_compile_prepend() {
        export GIR_EXTRA_LIBS_PATH="${B}/src/.libs"
}

CFLAGS += "-D_GNU_SOURCE"

EXTRA_OECONF = "--with-gnutls"

# libtool adds "-nostdlib" when g++ is used. This breaks PIE builds.
# Use libtool-cross (which has a hack to prevent that) instead.
EXTRA_OEMAKE_class-target = "LIBTOOL=${STAGING_BINDIR_CROSS}/${HOST_SYS}-libtool"

PACKAGES =+ "libvte"
FILES_libvte = "${libdir}/*.so.* ${libdir}/girepository-1.0/*"
