
/* This program prints all primes less than 1000
   using a technique called "The sieve of Eratosthenes". */

program Primes;

const Limit = 3;

var prime : array [2..Limit] of Boolean;
    i	  : integer;


begin {main program}
   i := 2;
   while i <= Limit do begin prime[i] := true;  i := i+1 end;
end. {main program}
