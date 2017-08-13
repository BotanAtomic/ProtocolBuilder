package com.ankamagames.dofus.network.messages.game.basic
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class NumericWhoIsMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6297;
       
      private var _isInitialized:Boolean = false;
      
      public var playerId:Number = 0;
      
      public var accountId:uint = 0;
      
      public function NumericWhoIsMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6297;
      }
      
      public function initNumericWhoIsMessage(param1:Number = 0, param2:uint = 0) : NumericWhoIsMessage
      {
         this.playerId = param1;
         this.accountId = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.playerId = 0;
         this.accountId = 0;
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
         this.serializeAs_NumericWhoIsMessage(param1);
      }
      
      public function serializeAs_NumericWhoIsMessage(param1:ICustomDataOutput) : void
      {
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
         if(this.accountId < 0)
         {
            throw new Error("Forbidden value (" + this.accountId + ") on element accountId.");
         }
         param1.writeInt(this.accountId);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_NumericWhoIsMessage(param1);
      }
      
      public function deserializeAs_NumericWhoIsMessage(param1:ICustomDataInput) : void
      {
         this._playerIdFunc(param1);
         this._accountIdFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_NumericWhoIsMessage(param1);
      }
      
      public function deserializeAsyncAs_NumericWhoIsMessage(param1:FuncTree) : void
      {
         param1.addChild(this._playerIdFunc);
         param1.addChild(this._accountIdFunc);
      }
      
      private function _playerIdFunc(param1:ICustomDataInput) : void
      {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.playerId + ") on element of NumericWhoIsMessage.playerId.");
         }
      }
      
      private function _accountIdFunc(param1:ICustomDataInput) : void
      {
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Error("Forbidden value (" + this.accountId + ") on element of NumericWhoIsMessage.accountId.");
         }
      }
   }
}
