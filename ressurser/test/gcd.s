# Code file created by Pascal2016 compiler 2016-11-29 11:15:28
        .globl  _main                   
_main:
        call    prog$gcd_1              # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$gcd_1:
        enter   $36,$1                  # Start of gcd
func$gcd_2:
        enter   $32,$1                  # Start of gcd
        popl    %ecx                    
        movl    $0,%eax                 #   0 Skrevet ut i: <number literal> on line 12
        cmpl    %eax,%ecx               
        movl    $0,%eax                 
        sete    %al                     
        movl    $0,%eax                 #   0 Skrevet ut i: <number literal> on line 12
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0003                  # Jump to .L0003
        movl    -8(%ebp),%edx           
        movl    %eax,-32(%edx)          
        jmp     .L0004                  # Jump to next label
.L0003:
                                        #  mod : Ikke implementert. Factor Opr
        pushl   %eax                    # Push value from expr to stack
        call    func$gcd_2              # Function call
        addl    $8,%esp                 # Remove stuff from stack
        movl    -8(%ebp),%edx           
        movl    %eax,-32(%edx)          
.L0004:
        movl    -32(%ebp),%eax          
        leave                           # End of gcd
        ret                             
        movl    $462,%eax               #   462 Skrevet ut i: <number literal> on line 6
        pushl   %eax                    # Push value from expr to stack
        call    func$gcd_2              # Function call
        addl    $8,%esp                 # Remove stuff from stack
        movl    -4(%ebp),%edx           
        movl    %eax,-4(%edx)           # res :=
        movl    $10,%eax                #   10 Skrevet ut i: <const decl> eol in the library
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    1(%ebp),%edx            
        movl    -4(%edx),%eax           #     res
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '=' Skrevet ut i: <char literal> on line 20
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $41,%eax                #   ')' Skrevet ut i: <char literal> on line 20
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $462,%eax               #   462 Skrevet ut i: <number literal> on line 6
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $44,%eax                #   ',' Skrevet ut i: <char literal> on line 20
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $1071,%eax              #   1071 Skrevet ut i: <number literal> on line 6
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $40,%eax                #   '(' Skrevet ut i: <char literal> on line 20
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $68,%eax                #   'D' Skrevet ut i: <char literal> on line 20
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $67,%eax                #   'C' Skrevet ut i: <char literal> on line 20
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $71,%eax                #   'G' Skrevet ut i: <char literal> on line 20
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        leave                           # End of gcd
        ret                             
