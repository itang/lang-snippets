val max = if(args.length > 0) args(0).toInt else 10
(1 to max).foreach{ i => println(i); Thread.sleep(1000) }
