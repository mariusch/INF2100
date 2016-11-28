# Code file created by Pascal2016 compiler 2016-11-28 12:34:11
        .globl  main                    
main:
        call    prog$nameerror_1        # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
func$doble_2:
        enter   $32,$2                  # Start of doble
        movl    $2,%eax                 #   2
        pushl   %eax                    
        movl    -8(%ebp),%edx           
        movl    8(%edx),%eax            #   v
        movl    %eax,%ecx               
        popl    %eax                    
        imull   %ecx,%eax               #   *
        movl    -8(%ebp),%edx           
        movl    %eax,-32(%edx)          # doble :=
        movl    -4(%ebp),%edx           
        movl    -36(%edx),%eax          #   x
        pushl   %eax                    
        movl    $2,%eax                 #   2
        pushl   %eax                    
        movl    -8(%ebp),%edx           
        movl    8(%edx),%eax            #   v
        movl    %eax,%ecx               
        popl    %eax                    
        imull   %ecx,%eax               #   *
        movl    %eax,%ecx               
        popl    %eax                    
        addl    %ecx,%eax               #   +
        movl    -4(%ebp),%edx           
        movl    %eax,-36(%edx)          # x :=
        movl    -32(%ebp),%eax          # Fetch return value
        leave                           # End of doble
        ret                             
prog$nameerror_1:
        enter   $36,$1                  # Start of nameerror
        movl    $6,%eax                 #   6
        pushl   %eax                    # Push param #1
        call    func$doble_2            
        addl    $4,%esp                 # Pop parameters
        movl    -4(%ebp),%edx           
        movl    %eax,-36(%edx)          # x :=
        leave                           # End of nameerror
        ret                             
