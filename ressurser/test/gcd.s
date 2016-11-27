# Code file created by Pascal2016 compiler 2016-11-27 19:07:44
        .globl  _main                   
_main:
        call    prog$gcd_1              # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$gcd_1:
        enter   $32,$1                  # Start of gcd
func$gcd_2:
        enter   $32,$1                  # Start of gcd
        popl    %ecx                    # --simple expr: =
        movl    $0,%eax                 #   0
        cmpl    %eax,%ecx               # --simple expr: =
        movl    $0,%eax                 # --simple expr: =
        sete    %al                     # --simple expr: =
        movl    $0,%eax                 #   0
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0003                  # Jump to .L0003
        movl    -4(%ebp),%edx           
        movl    %eax,-32(%edx)          
        jmp     .L0004                  # Jump to next label
.L0003:
                                        #  mod : Ikke implementert. Factor Opr
        pushl   %eax                    # Push value from expr to stack
        call    func$gcd_2              # Function call
        addl    $8,%esp                 # Remove stuff from stack
        movl    -4(%ebp),%edx           
        movl    %eax,-32(%edx)          
.L0004:
        movl    -32(%ebp),%eax          
        leave                           # End of gcd
        ret                             
        movl    $10,%eax                #     10v2
        pushl   %eax                    # Push value from expr to stack
        call    func$gcd_2              # Function call
        addl    $8,%esp                 # Remove stuff from stack
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            # res :=
        movl    $10,%eax                #     10eol
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    -4(%ebp),%edx           
        movl    0(%edx),%eax            #     res
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $61,%eax                #   '='
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $41,%eax                #   ')'
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $10,%eax                #     10v2
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $44,%eax                #   ','
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $10,%eax                #     10v1
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $40,%eax                #   '('
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $68,%eax                #   'D'
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $67,%eax                #   'C'
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $71,%eax                #   'G'
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        leave                           # End of gcd
        ret                             
