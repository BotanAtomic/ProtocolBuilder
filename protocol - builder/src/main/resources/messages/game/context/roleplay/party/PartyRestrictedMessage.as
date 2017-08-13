package com.ankamagames.dofus.network.messages.game.context.roleplay.party
{
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class PartyRestrictedMessage extends AbstractPartyMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6175;
       
      private var _isInitialized:Boolean = false;
      
      public var restricted:Boolean = false;
      
      public function PartyRestrictedMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return super.isInitialized && this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6175;
      }
      
      public function initPartyRestrictedMessage(param1:uint = 0, param2:Boolean = false) : PartyRestrictedMessage
      {
         super.initAbstractPartyMessage(param1);
         this.restricted = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
         this.restricted = false;
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
         this.serializeAs_PartyRestrictedMessage(param1);
      }
      
      public function serializeAs_PartyRestrictedMessage(param1:ICustomDataOutput) : void
      {
         super.serializeAs_AbstractPartyMessage(param1);
         param1.writeBoolean(this.restricted);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_PartyRestrictedMessage(param1);
      }
      
      public function deserializeAs_PartyRestrictedMessage(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
         this._restrictedFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_PartyRestrictedMessage(param1);
      }
      
      public function deserializeAsyncAs_PartyRestrictedMessage(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._restrictedFunc);
      }
      
      private function _restrictedFunc(param1:ICustomDataInput) : void
      {
         this.restricted = param1.readBoolean();
      }
   }
}
