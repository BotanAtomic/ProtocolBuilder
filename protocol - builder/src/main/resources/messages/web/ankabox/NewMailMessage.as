package com.ankamagames.dofus.network.messages.web.ankabox
{
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class NewMailMessage extends MailStatusMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6292;
       
      private var _isInitialized:Boolean = false;
      
      public var sendersAccountId:Vector.<uint>;
      
      private var _sendersAccountIdtree:FuncTree;
      
      public function NewMailMessage()
      {
         this.sendersAccountId = new Vector.<uint>();
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return super.isInitialized && this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6292;
      }
      
      public function initNewMailMessage(param1:uint = 0, param2:uint = 0, param3:Vector.<uint> = null) : NewMailMessage
      {
         super.initMailStatusMessage(param1,param2);
         this.sendersAccountId = param3;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
         this.sendersAccountId = new Vector.<uint>();
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
      
      override public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_NewMailMessage(param1);
      }
      
      public function serializeAs_NewMailMessage(param1:ICustomDataOutput) : void
      {
         super.serializeAs_MailStatusMessage(param1);
         param1.writeShort(this.sendersAccountId.length);
         var _loc2_:uint = 0;
         while(_loc2_ < this.sendersAccountId.length)
         {
            if(this.sendersAccountId[_loc2_] < 0)
            {
               throw new Error("Forbidden value (" + this.sendersAccountId[_loc2_] + ") on element 1 (starting at 1) of sendersAccountId.");
            }
            param1.writeInt(this.sendersAccountId[_loc2_]);
            _loc2_++;
         }
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_NewMailMessage(param1);
      }
      
      public function deserializeAs_NewMailMessage(param1:ICustomDataInput) : void
      {
         var _loc4_:uint = 0;
         super.deserialize(param1);
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readInt();
            if(_loc4_ < 0)
            {
               throw new Error("Forbidden value (" + _loc4_ + ") on elements of sendersAccountId.");
            }
            this.sendersAccountId.push(_loc4_);
            _loc3_++;
         }
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_NewMailMessage(param1);
      }
      
      public function deserializeAsyncAs_NewMailMessage(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         this._sendersAccountIdtree = param1.addChild(this._sendersAccountIdtreeFunc);
      }
      
      private function _sendersAccountIdtreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            this._sendersAccountIdtree.addChild(this._sendersAccountIdFunc);
            _loc3_++;
         }
      }
      
      private function _sendersAccountIdFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readInt();
         if(_loc2_ < 0)
         {
            throw new Error("Forbidden value (" + _loc2_ + ") on elements of sendersAccountId.");
         }
         this.sendersAccountId.push(_loc2_);
      }
   }
}
