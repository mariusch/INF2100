# Code file created by Pascal2016 compiler 2016-11-29 13:41:48
        .globl  _main                   
_main:
        call    prog$primes_1           # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$primes_1:
        enter   $40,$1                  # Start of primes
proc$findprimes_2:
        enter   $-32,$1                 # Start of findprimes
        movl    $2,%eax                 #   2
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # i1 :=
.L0003:
                                        # Start while-statement
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   i1
        pushl   %eax                    
        movl    $1000,%eax              #   1000
        popl    %ecx                    
        cmpl    %eax,%ecx               
        movl    $0,%eax                 
        setle   %al                     # Test <=
        cmpl    $0,%eax                 
        je      .L0004                  
        movl    $2,%eax                 #   2
        pushl   %eax                    
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   i1
        movl    %eax,%ecx               
        popl    %eax                    
        imull   %ecx,%eax               #   *
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # i2 :=
.L0005:
                                        # Start while-statement
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   i2
        pushl   %eax                    
        movl    $1000,%eax              #   1000
        popl    %ecx                    
        cmpl    %eax,%ecx               
        movl    $0,%eax                 
        setle   %al                     # Test <=
        cmpl    $0,%eax                 
        je      .L0006                  
        movl    $0,%eax                 #   0
        movl    -4(%ebp),%edx           
        movl    %eax,-4(%edx)           # prime :=
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   i2
        pushl   %eax                    
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   i1
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               #   +
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # i2 :=
        jmp     .L0005                  
.L0006:
                                        # End while-statement
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   i1
        pushl   %eax                    
        movl    $1,%eax                 #   1
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               #   +
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # i1 :=
        jmp     .L0003                  
.L0004:
                                        # End while-statement
        leave                           # End of findprimes
        ret                             
proc$p4_7:
        enter   $-28,$1                 # Start of p4
                                        # Start if-statement
        pushl   %eax                    
        movl    $1000,%eax              #   1000
        popl    %ecx                    
        cmpl    %eax,%ecx               
        movl    $0,%eax                 
        setl    %al                     # Test <
        cmpl    $0,%eax                 
        je      .L0008                  
        movl    $32,%eax                #   ' '
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
.L0008:
                                        # End if-statement
                                        # Start if-statement
        pushl   %eax                    
        movl    $100,%eax               #   100
        popl    %ecx                    
        cmpl    %eax,%ecx               
        movl    $0,%eax                 
        setl    %al                     # Test <
        cmpl    $0,%eax                 
        je      .L0010                  
        movl    $32,%eax                #   ' '
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
.L0010:
                                        # End if-statement
                                        # Start if-statement
        pushl   %eax                    
        movl    $10,%eax                #   10
        popl    %ecx                    
        cmpl    %eax,%ecx               
        movl    $0,%eax                 
        setl    %al                     # Test <
        cmpl    $0,%eax                 
        je      .L0012                  
        movl    $32,%eax                #   ' '
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
.L0012:
                                        # End if-statement
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        leave                           # End of p4
        ret                             
proc$printprimes_14:
        enter   $-32,$1                 # Start of printprimes
        movl    $2,%eax                 #   2
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # i :=
        movl    $0,%eax                 #   0
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # nprinted :=
.L0015:
                                        # Start while-statement
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   i
        pushl   %eax                    
        movl    $1000,%eax              #   1000
        popl    %ecx                    
        cmpl    %eax,%ecx               
        movl    $0,%eax                 
        setle   %al                     # Test <=
        cmpl    $0,%eax                 
        je      .L0016                  
                                        # Start if-statement
        movl    -4(%ebp),%edx           
        movl    -4(%edx),%eax           #   prime
        cmpl    $0,%eax                 
        je      .L0017                  
                                        # Start if-statement
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   nprinted
        pushl   %eax                    
        movl    $0,%eax                 #   0
        popl    %ecx                    
        cmpl    %eax,%ecx               
        movl    $0,%eax                 
        setg    %al                     # Test >
        pushl   %eax                    
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   nprinted
        pushl   %eax                    
        movl    $10,%eax                #   10
        movl    %eax,%ecx               
        popl    %eax                    
        cdq                             
        idivl   %ecx                    
        movl    %edx,%eax               #   mod
        popl    %ecx                    
        movl    $0,%eax                 #   0
        popl    %ecx                    
        cmpl    %eax,%ecx               
        movl    $0,%eax                 
        sete    %al                     # Test =
        movl    %eax,%ecx               
        popl    %eax                    
        andl    %ecx,%eax               #   and
        cmpl    $0,%eax                 
        je      .L0019                  
        movl    $10,%eax                #   10
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
.L0019:
                                        # End if-statement
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   i
        pushl   %eax                    # Push next param.
        call    proc$p4_7               # Proc call
        addl    $4,%esp                 # Pop param.
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   nprinted
        pushl   %eax                    
        movl    $1,%eax                 #   1
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               #   +
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # nprinted :=
.L0017:
                                        # End if-statement
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   i
        pushl   %eax                    
        movl    $1,%eax                 #   1
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               #   +
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # i :=
        jmp     .L0015                  
.L0016:
                                        # End while-statement
        movl    $10,%eax                #   10
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        leave                           # End of printprimes
        ret                             
        movl    $2,%eax                 #   2
        movl    -4(%ebp),%edx           
        movl    %eax,-4(%edx)           # i :=
.L0021:
                                        # Start while-statement
        movl    -4(%ebp),%edx           
        movl    -4(%edx),%eax           #   i
        pushl   %eax                    
        movl    $1000,%eax              #   1000
        popl    %ecx                    
        cmpl    %eax,%ecx               
        movl    $0,%eax                 
        setle   %al                     # Test <=
        cmpl    $0,%eax                 
        je      .L0022                  
        movl    $1,%eax                 #   1
        movl    -4(%ebp),%edx           
        movl    %eax,-4(%edx)           # prime :=
        movl    -4(%ebp),%edx           
        movl    -4(%edx),%eax           #   i
        pushl   %eax                    
        movl    $1,%eax                 #   1
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               #   +
        movl    -4(%ebp),%edx           
        movl    %eax,-4(%edx)           # i :=
        jmp     .L0021                  
.L0022:
                                        # End while-statement
        leave                           # End of primes
        ret                             
