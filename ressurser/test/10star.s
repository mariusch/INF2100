# Code file created by Pascal2016 compiler 2016-11-28 15:58:59
        .globl  _main                   
_main:
        call    prog$tenstars_1         # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$tenstars_1:
        enter   $36,$1                  # Start of tenstars
        movl    $0,%eax                 #   0 Skrevet ut i: <number literal> on line 5
        movl    -4(%ebp),%edx           
        movl    %eax,-4(%edx)           # i :=
.L0002:
                                        # Start while-statement
        movl    1(%ebp),%edx            
        movl    -4(%edx),%eax           #     i
        push    %eax                    
        movl    $10,%eax                #   10 Skrevet ut i: <number literal> on line 2
        popl    %ecx                    
        cmpl    %eax,%ecx               
        movl    $0,%eax                 
        setl    %al                     # Test <
        movl    $10,%eax                #   10 Skrevet ut i: <number literal> on line 2
        cmpl    $0,%eax                 
        je      .L0003                  
        movl    $42,%eax                #   '*' Skrevet ut i: <char literal> on line 7
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    1(%ebp),%edx            
        movl    -4(%edx),%eax           #     i
        pushl   %eax                    
        movl    $1,%eax                 #   1 Skrevet ut i: <number literal> on line 7
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               #    +
        movl    $1,%eax                 #   1 Skrevet ut i: <number literal> on line 7
        movl    -4(%ebp),%edx           
        movl    %eax,-4(%edx)           # i :=
        jmp     .L0002                  
.L0003:
                                        # End while-statement
        movl    $10,%eax                #   10 Skrevet ut i: <const decl> eol in the library
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        leave                           # End of tenstars
        ret                             
