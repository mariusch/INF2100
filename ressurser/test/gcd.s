# Code file created by Pascal2016 compiler 2016-12-02 15:31:01
        .globl  _main                   
_main:
        call    prog$gcd_1              # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   m
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   n
proc$gcd_2:
        enter   $-24,$1                 # Start of function
                                        # Start if-statement
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   n
        popl    %ecx                    
        movl    $0,%eax                 #   0
        popl    %ecx                    
        cmpl    %eax,%ecx               
        movl    $0,%eax                 
        sete    %al                     # Test =
        cmpl    $0,%eax                 
        je      .L0003                  
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   m
        movl    -8(%ebp),%edx           
        movl    %eax,-32(%edx)          
        jmp     .L0004                  # Jump to next label
.L0003:
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   m
        pushl   %eax                    
        movl    -8(%ebp),%edx           
        movl    -4(%edx),%eax           #   n
        movl    %eax,%ecx               
        popl    %eax                    
        cdq                             
        idivl   %ecx                    
        movl    %edx,%eax               #   mod
        pushl   %eax                    # Push value from expr to stack
        call    null                    
        addl    $8,%esp                 # Remove stuff from stack
        movl    -8(%ebp),%edx           
        movl    %eax,-32(%edx)          
.L0004:
                                        # End if-statement
        movl    -32(%ebp),%eax          # Fetch return value
        leave                           # End of gcd
        ret                             
prog$gcd_1:
        enter   $36,$1                  # Start of gcd
        movl    $462,%eax               #   462
        pushl   %eax                    # Push value from expr to stack
        call    null                    
        addl    $8,%esp                 # Remove stuff from stack
        movl    -4(%ebp),%edx           
        movl    %eax,-4(%edx)           # res :=
        movl    $71,%eax                #   'G'
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $67,%eax                #   'C'
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $68,%eax                #   'D'
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $40,%eax                #   '('
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $1071,%eax              #   1071
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $44,%eax                #   ','
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $462,%eax               #   462
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $41,%eax                #   ')'
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '='
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    -4(%ebp),%edx           
        movl    -4(%edx),%eax           #   res
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $10,%eax                #   10
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        leave                           # End of gcd
        ret                             
