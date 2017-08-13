package com.ankamagames.dofus.network.messages.game.inventory.items
{
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class ObjectUseOnCharacterMessage extends ObjectUseMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 3003;
       
      private var _isInitialized:Boolean = false;
      
      public var characterId:Number = 0;
      
      public function ObjectUseOnCharacterMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return super.isInitialized && this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 3003;
      }
      
      public function initObjectUseOnCharacterMessage(param1:uint = 0, param2:Number = 0) : ObjectUseOnCharacterMessage
      {
         super.initObjectUseMessage(param1);
         this.characterId = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
         this.characterId = 0;
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
         this.serializeAs_ObjectUseOnCharacterMessage(param1);
      }
      
      public function serializeAs_ObjectUseOnCharacterMessage(param1:ICustomDataOutput) : void
      {
         super.serializeAs_ObjectUseMessage(param1);
         if(this.characterId < 0 || this.characterId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.characterId + ") on element characterId.");
         }
         param1.writeVarLong(this.characterId);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_ObjectUseOnCharacterMessage(param1);
      }
      
      public function deserializeAs_ObjectUseOnCharacterMessage(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
         this._characterIdFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_ObjectUseOnCharacterMessage(param1);
      }
      
      public function deserializeAsyncAs_ObjectUseOnCharacterMessage(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._characterIdFunc);
      }
      
      private function _characterIdFunc(param1:ICustomDataInput) : void
      {
         this.characterId = param1.readVarUhLong();
         if(this.characterId < 0 || this.characterId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.characterId + ") on element of ObjectUseOnCharacterMessage.characterId.");
         }
      }
   }
}
