#### tar

##### uncompress xxx.tar.gz
tar -zxvf xxx.tar.gz

##### uncompress xxx.tar.bz2
tar -jxvf ×××.tar.bz2



##### compress
```bash
# //将目录里所有jpg文件打包成tar.jpg
tar cvf jpg.tar *.jpg 
# //将目录里所有jpg文件打包成jpg.tar后，并且将其用gzip压缩，生成一个gzip压缩过的包，命名为jpg.tar.gz
tar czf jpg.tar.gz *.jpg 
# //将目录里所有jpg文件打包成jpg.tar后，并且将其用bzip2压缩，生成一个bzip2压缩过的包，命名为jpg.tar.bz2 
tar cjf jpg.tar.bz2 *.jpg 
# //将目录里所有jpg文件打包成jpg.tar后，并且将其用compress压缩，生成一个uncompress压缩过的包，命名为jpg.tar.Z
tar cZf jpg.tar.Z *.jpg   
```

