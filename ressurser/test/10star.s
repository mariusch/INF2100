# Code file created by Pascal2016 compiler 2016-11-28 15:28:24
        .globl  _main                   
_main:
        call    prog$tenstars_1         # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$tenstars_1:
        enter   $32,$1                  # Start of tenstars
        movl    $0,%eax                 #   0
        movl    -4(%ebp),%edx           
        movl    %eax,-4(%edx)           # i :=
.L0002:
                                        # Start while-statement
        movl    -4(%ebp),%edx           
        movl    0(%edx),%eax            #     i Skrevet ut i: parser.VarDecl@49476842
        push    %eax                    
        movl    $10,%eax                #   10
        popl    %ecx                    
        cmpl    %eax,%ecx               
        movl    $0,%eax                 
        setl    %al                     # Test <
        movl    $10,%eax                #   10
        cmpl    $0,%eax                 
        je      .L0003                  
        movl    $42,%eax                #   '*'
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    -4(%ebp),%edx           
        movl    0(%edx),%eax            #     i Skrevet ut i: parser.VarDecl@49476842
        movl    -4(%ebp),%edx           
        movl    0(%edx),%eax            #     i Skrevet ut i: parser.VarDecl@49476842
        pushl   %eax                    
        movl    $1,%eax                 #   1
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               #    +
        movl    $1,%eax                 #   1
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
