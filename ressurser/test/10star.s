# Code file created by Pascal2016 compiler 2016-11-27 15:02:26
        .globl  _main                   
_main:
        call    prog$tenstars_1         # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$tenstars_1:
        enter   $32,$1                  # Start of tenstars
        movl    $0,%eax                 #   0
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            # i :=
.L0002:
                                        # Start while-statement
                                        #  < : Ikke implementert. Rel Opr
        cmpl    $0,%eax                 
        je      .L0003                  
        movl    $42,%eax                #   '*'
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               #    +
        movl    $1,%eax                 #   1
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            # i :=
        jmp     .L0002                  
.L0003:
                                        # End while-statement
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        leave                           # End of tenstars
        ret                             
