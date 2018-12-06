function check {
    IFS=
    s=""
    cat $1 | while read l; do
        s="$s$(echo $l | sed 's/\s//g')\n"
        h=$(echo -ne "$s" | md5sum)
        echo "${h:0:2}  $l"
    done
}
