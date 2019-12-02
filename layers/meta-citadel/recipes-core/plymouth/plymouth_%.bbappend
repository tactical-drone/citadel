
FILES_${PN} += "/lib /sbin /bin"

INSANE_SKIP_${PN} += "dev-so"
INSANE_SKIP_${PN} += "libdir"
INSANE_SKIP_${PN} += "usrmerge"
INSANE_SKIP_${PN}-dbg+= "libdir"
INSANE_SKIP_${PN}-dbg+= "usrmerge"


