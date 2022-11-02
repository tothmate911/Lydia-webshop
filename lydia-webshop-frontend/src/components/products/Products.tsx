import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Product } from './Product'
import ProductCard from './ProductCard';

import CardGroup from 'react-bootstrap/CardGroup';

const Products = () => {

    const [products, setProducts] = useState<Product[]>([]);

    useEffect(() => {
        axios.get("/products")
            .then((response) => {
                const products: Product[] = response.data;
                setProducts(products);
            })
            .catch((error) => {
                console.log(error);
            });
    }, []);

    return (
        <div className="productCardsContainer">
             <CardGroup>
            {products.map(product => (
                <ProductCard key={product.id} product={product} />
            ))}
            </CardGroup>
        </div>
    )
}

export default Products