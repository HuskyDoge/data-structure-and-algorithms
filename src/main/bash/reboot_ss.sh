#!/usr/bin/env bash

echo $(/etc/init.d/shadowsocks restart) | grep -o -E '[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9:]+' >> test.txt

