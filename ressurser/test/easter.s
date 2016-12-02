# Code file created by Pascal2016 compiler 2016-12-02 16:37:01
        .globl  _main                   
_main:
        call    prog$easter_1           # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
proc$easter_2:
        enter   $-28,$1                 # Start of easter
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # a :=
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # b :=
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # c :=
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # d :=
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # e :=
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # f :=
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # g :=
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # h :=
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # i :=
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # k :=
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # l :=
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # m :=
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # month :=
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   h
        pushl   %eax                    
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   l
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               #   +
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   h
        pushl   %eax                    
        movl    $7,%eax                 #   7
        pushl   %eax                    
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   m
        movl    %eax,%ecx               
        popl    %eax                    
        imull   %ecx,%eax               #   *
        movl    %eax,%ecx               
        popl    %eax                    
        subl    %ecx,%eax               #   -
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   h
        pushl   %eax                    
        movl    $114,%eax               #   114
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               #   +
        pushl   %eax                    
        movl    $31,%eax                #   31
        movl    %eax,%ecx               
        popl    %eax                    
        cdq                             
        idivl   %ecx                    
        movl    %edx,%eax               #   mod
        pushl   %eax                    
        movl    $1,%eax                 #   1
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               #   +
        movl    -8(%ebp),%edx           
        movl    %eax,-4(%edx)           # day :=
                                        # Start if-statement
        pushl   %eax                    
        popl    %ecx                    
        cmpl    %eax,%ecx               
        movl    $0,%eax                 
        sete    %al                     # Test =
        cmpl    $0,%eax                 
        je      .L0003                  
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        jmp     .L0004                  
.L0003:
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
.L0004:
                                        # End if-statement
        leave                           # End of easter
        ret                             
prog$easter_1:
        enter   $36,$1                  # Start of easter
        movl    -4(%ebp),%edx           
        movl    %eax,-4(%edx)           # y :=
.L0005:
                                        # Start while-statement
        pushl   %eax                    
        popl    %ecx                    
        cmpl    %eax,%ecx               
        movl    $0,%eax                 
        setle   %al                     # Test <=
        cmpl    $0,%eax                 
        je      .L0006                  
        pushl   %eax                    # Push param #1.
        call    proc$easter_2           
        addl    $4,%esp                 # Pop params.
        movl    -4(%ebp),%edx           
        movl    -4(%edx),%eax           #   y
        pushl   %eax                    
        movl    $1,%eax                 #   1
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               #   +
        movl    -4(%ebp),%edx           
        movl    %eax,-4(%edx)           # y :=
        jmp     .L0005                  
.L0006:
                                        # End while-statement
        leave                           # End of easter
        ret                             
