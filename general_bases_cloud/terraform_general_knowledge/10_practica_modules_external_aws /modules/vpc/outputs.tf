output "public_subnet_id" {
    value = aws_subnet.subnet-ate-public.id
}

output "sg-vpc-id" {
    value = aws_security_group.sg-ate.id
}