# Code file created by Pascal2016 compiler 2016-11-25 12:17:05
        .globl  main                    
main:
        call    prog$gcd_1              # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$gcd_1:
        enter   $32,$1                  # Start of gcd
        movl    $1071,%eax              #   1071
        movl    $462,%eax               #   462
        enter   $32,$1                  # Start of BLANK
        movl    $0,%eax                 #   0
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0041                  # Jump to .L0041
        movl    -4(%ebp),%edx           
        movl    %eax,-32(%edx)          
        jmp     .L0042                  # Jump to next label
.L0041:
                                        # ?
func$gcd_24:
        enter   $32,$1                  # Start of gcd
        pushl   %eax                    # Push value from expr to stack
        call    func$gcd_24             # Function call
        addl    $8,%esp                 # Remove stuff from stack
        movl    -4(%ebp),%edx           
        movl    %eax,-32(%edx)          
.L0042:
                                        # ??
        leave                           # End of BLANK
        ret                             
func$gcd_24:
        enter   $32,$1                  # Start of gcd
        pushl   %eax                    # Push value from expr to stack
        call    func$gcd_24             # Function call
        addl    $8,%esp                 # Remove stuff from stack
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            # ?
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
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
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        movl    $44,%eax                #   ','
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
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
