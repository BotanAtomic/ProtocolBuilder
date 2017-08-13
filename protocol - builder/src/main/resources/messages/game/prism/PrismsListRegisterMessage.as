package com.ankamagames.dofus.network.messages.game.prism
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class PrismsListRegisterMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6441;
       
      private var _isInitialized:Boolean = false;
      
      public var listen:uint = 0;
      
      public function PrismsListRegisterMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6441;
      }
      
      public function initPrismsListRegisterMessage(param1:uint = 0) : PrismsListRegisterMessage
      {
         this.listen = param1;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.listen = 0;
         this._isInitialized = false;
      }
      
      override public function pack(param1:ICustomDataOutput) : void
      {
         var _loc2_:ByteArray = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
      }
      
      override public function unpack(param1:ICustomDataInput, param2:uint) : void
      {
         this.deserialize(param1);
      }
      
      override public function unpackAsync(param1:ICustomDataInput, param2:uint) : FuncTree
      {
         var _loc3_:FuncTree = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
      }
      
      public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_PrismsListRegisterMessage(param1);
      }
      
      public function serializeAs_PrismsListRegisterMessage(param1:ICustomDataOutput) : void
      {
         param1.writeByte(this.listen);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_PrismsListRegisterMessage(param1);
      }
      
      public function deserializeAs_PrismsListRegisterMessage(param1:ICustomDataInput) : void
      {
         this._listenFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_PrismsListRegisterMessage(param1);
      }
      
      public function deserializeAsyncAs_PrismsListRegisterMessage(param1:FuncTree) : void
      {
         param1.addChild(this._listenFunc);
      }
      
      private function _listenFunc(param1:ICustomDataInput) : void
      {
         this.listen = param1.readByte();
         if(this.listen < 0)
         {
            throw new Error("Forbidden value (" + this.listen + ") on element of PrismsListRegisterMessage.listen.");
         }
      }
   }
}
