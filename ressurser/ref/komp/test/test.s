# Code file created by Pascal2016 compiler 2016-11-28 12:35:03
        .globl  main                    
main:
        call    prog$p1_1               # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$p1_1:
        enter   $40,$1                  # Start of p1
        movl    $0,%eax                 #   0
        movl    -4(%ebp),%edx           
        movl    %eax,-36(%edx)          # i :=
        movl    $1,%eax                 #   1
        movl    -4(%ebp),%edx           
        movl    %eax,-40(%edx)          # p :=
.L0002:
                                        # Start while-statement
        movl    -4(%ebp),%edx           
        movl    -36(%edx),%eax          #   i
        pushl   %eax                    
        movl    $10,%eax                #   10
        popl    %ecx                    
        cmpl    %eax,%ecx               
        movl    $0,%eax                 
        setle   %al                     # Test <=
        cmpl    $0,%eax                 
        je      .L0003                  
        movl    $2,%eax                 #   2
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $94,%eax                #   '^'
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    -4(%ebp),%edx           
        movl    -36(%edx),%eax          #   i
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '='
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    -4(%ebp),%edx           
        movl    -40(%edx),%eax          #   p
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $10,%eax                #   10
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    -4(%ebp),%edx           
        movl    -36(%edx),%eax          #   i
        pushl   %eax                    
        movl    $1,%eax                 #   1
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               #   +
        movl    -4(%ebp),%edx           
        movl    %eax,-36(%edx)          # i :=
        movl    $2,%eax                 #   2
        pushl   %eax                    
        movl    -4(%ebp),%edx           
        movl    -40(%edx),%eax          #   p
        movl    %eax,%ecx               
        popl    %eax                    
        imull   %ecx,%eax               #   *
        movl    -4(%ebp),%edx           
        movl    %eax,-40(%edx)          # p :=
        jmp     .L0002                  
.L0003:
                                        # End while-statement
        leave                           # End of p1
        ret                             
