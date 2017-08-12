package data.messages.game.context.roleplay.party
{
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class PartyRefuseInvitationNotificationMessage extends AbstractPartyEventMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 5596;
       
      private var _isInitialized:Boolean = false;
      
      public var guestId:Number = 0;
      
      public function PartyRefuseInvitationNotificationMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return super.isInitialized && this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 5596;
      }
      
      public function initPartyRefuseInvitationNotificationMessage(param1:uint = 0, param2:Number = 0) : PartyRefuseInvitationNotificationMessage
      {
         super.initAbstractPartyEventMessage(param1);
         this.guestId = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
         this.guestId = 0;
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
         this.serializeAs_PartyRefuseInvitationNotificationMessage(param1);
      }
      
      public function serializeAs_PartyRefuseInvitationNotificationMessage(param1:ICustomDataOutput) : void
      {
         super.serializeAs_AbstractPartyEventMessage(param1);
         if(this.guestId < 0 || this.guestId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.guestId + ") on element guestId.");
         }
         param1.writeVarLong(this.guestId);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_PartyRefuseInvitationNotificationMessage(param1);
      }
      
      public function deserializeAs_PartyRefuseInvitationNotificationMessage(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
         this._guestIdFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_PartyRefuseInvitationNotificationMessage(param1);
      }
      
      public function deserializeAsyncAs_PartyRefuseInvitationNotificationMessage(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._guestIdFunc);
      }
      
      private function _guestIdFunc(param1:ICustomDataInput) : void
      {
         this.guestId = param1.readVarUhLong();
         if(this.guestId < 0 || this.guestId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.guestId + ") on element of PartyRefuseInvitationNotificationMessage.guestId.");
         }
      }
   }
}
