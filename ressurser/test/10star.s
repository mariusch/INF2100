<<<<<<< HEAD
# Code file created by Pascal2016 compiler 2016-11-25 13:04:39
=======
# Code file created by Pascal2016 compiler 2016-11-25 12:17:59
>>>>>>> origin/master
        .globl  main                    
main:
        call    prog$tenstars_1         # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$tenstars_1:
        enter   $32,$1                  # Start of tenstars
        movl    $10,%eax                #   10
        movl    $0,%eax                 #   0
        pushl   %eax                    
        movl    0(%ebp),%edx            
<<<<<<< HEAD
        movl    %eax,0(%edx)            # i :=
=======
        movl    %eax,0(%edx)            
>>>>>>> origin/master
.L0028:
                                        # Start while-statement
        pushl   %eax                    
        pushl   %eax                    
        cmpl    $0,%eax                 
        je      .L0029                  
        movl    $42,%eax                #   '*'
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        movl    $1,%eax                 #   1
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               #    +
        movl    0(%ebp),%edx            
<<<<<<< HEAD
        movl    %eax,0(%edx)            # i :=
=======
        movl    %eax,0(%edx)            
>>>>>>> origin/master
        jmp     .L0028                  
.L0029:
                                        # End while-statement
        pushl   %eax                    
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        leave                           # End of tenstars
        ret                             
