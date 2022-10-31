import React from 'react'
import { Product } from './Product'

interface Props {
  product: Product;
}

const ProductCard: React.FC<Props> = ({ product }) => {
  return (
    <div>name: {product.name} prize: {product.prize}</div>
  )
}

export default ProductCard