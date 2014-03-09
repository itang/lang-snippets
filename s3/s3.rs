use std::io::Timer;
use std::os;

fn main() {
   let args = os::args();
   let max = match args.len() {
        1 => 10,
        _ => from_str::<int>(args[1]).unwrap()
    };
    let mut timer = Timer::new().unwrap();
    for i in range(1, max+1) {
        println!("{:d}", i);
        timer.sleep(1000);
    }
}
