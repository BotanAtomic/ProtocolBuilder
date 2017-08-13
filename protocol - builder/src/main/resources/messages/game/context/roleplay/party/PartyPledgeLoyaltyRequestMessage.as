package com.ankamagames.dofus.network.messages.game.context.roleplay.party
{
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class PartyPledgeLoyaltyRequestMessage extends AbstractPartyMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6269;
       
      private var _isInitialized:Boolean = false;
      
      public var loyal:Boolean = false;
      
      public function PartyPledgeLoyaltyRequestMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return super.isInitialized && this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6269;
      }
      
      public function initPartyPledgeLoyaltyRequestMessage(param1:uint = 0, param2:Boolean = false) : PartyPledgeLoyaltyRequestMessage
      {
         super.initAbstractPartyMessage(param1);
         this.loyal = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
         this.loyal = false;
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
         this.serializeAs_PartyPledgeLoyaltyRequestMessage(param1);
      }
      
      public function serializeAs_PartyPledgeLoyaltyRequestMessage(param1:ICustomDataOutput) : void
      {
         super.serializeAs_AbstractPartyMessage(param1);
         param1.writeBoolean(this.loyal);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_PartyPledgeLoyaltyRequestMessage(param1);
      }
      
      public function deserializeAs_PartyPledgeLoyaltyRequestMessage(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
         this._loyalFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_PartyPledgeLoyaltyRequestMessage(param1);
      }
      
      public function deserializeAsyncAs_PartyPledgeLoyaltyRequestMessage(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._loyalFunc);
      }
      
      private function _loyalFunc(param1:ICustomDataInput) : void
      {
         this.loyal = param1.readBoolean();
      }
   }
}
