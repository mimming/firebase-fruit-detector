//
//  ViewController.swift
//  Fruit Detector
//
//  Created by Jenny Tong on 3/11/15.
//  Copyright (c) 2015 Firebase. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var textView: UITextField!

    override func viewDidLoad() {
        super.viewDidLoad()
        
        let myRootRef = Firebase(url:"https://fruit.firebaseio-demo.com/type/")
        
        myRootRef.observeEventType(.Value, withBlock: {
            snapshot in
            
            let fruit = "\(snapshot.value)"

            self.textView.text = fruit
            
            if(fruit == "apple") {
                self.imageView.image = UIImage(named: "apple")
            } else if(fruit == "orange") {
                self.imageView.image = UIImage(named: "orange")
            } else {
                self.imageView.image = UIImage(named: "ic_stop")
            }
        })
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


    
    
    
}

