#!/bin/bash
#
# Usage: iptables-flush [6]
#

iptables=ip$1tables
if ! type -p "$iptables" &>/dev/null; then
  echo "error: invalid argument"
  exit 1
fi

while read -r table; do
  tables+=("/usr/share/iptables/empty-$table.rules")
done <"/proc/net/ip$1_tables_names"

if (( ${#tables[*]} )); then
  cat "${tables[@]}" | "$iptables-restore"
fi

