default: build run clean

build:
	mkdir -p .tmp
	rustc s3.rs --out-dir .tmp
	go build -o .tmp/s3go s3.go

run:
	./.tmp/s3 5

	./.tmp/s3go 5

	ruby s3.rb 5

	scala s3.scala 5

clean:
	rm -rf .tmp