import React from 'react';
import { Product } from './Product';

import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

interface Props {
  product: Product;
}

const ProductCard: React.FC<Props> = ({ product }) => {
  return (
    <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src={product.mainImagePath} />
      <Card.Body>
        <Card.Title>{product.name}</Card.Title>
        <Card.Text>{product.description}</Card.Text>
        <Button variant="primary">Buy</Button>
      </Card.Body>
    </Card>
  )
}

export default ProductCard
