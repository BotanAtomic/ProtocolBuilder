package com.ankamagames.dofus.network.messages.game.context.roleplay.job
{
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobExperience;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class JobExperienceOtherPlayerUpdateMessage extends JobExperienceUpdateMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6599;
       
      private var _isInitialized:Boolean = false;
      
      public var playerId:Number = 0;
      
      public function JobExperienceOtherPlayerUpdateMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return super.isInitialized && this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6599;
      }
      
      public function initJobExperienceOtherPlayerUpdateMessage(param1:JobExperience = null, param2:Number = 0) : JobExperienceOtherPlayerUpdateMessage
      {
         super.initJobExperienceUpdateMessage(param1);
         this.playerId = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
         this.playerId = 0;
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
         this.serializeAs_JobExperienceOtherPlayerUpdateMessage(param1);
      }
      
      public function serializeAs_JobExperienceOtherPlayerUpdateMessage(param1:ICustomDataOutput) : void
      {
         super.serializeAs_JobExperienceUpdateMessage(param1);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_JobExperienceOtherPlayerUpdateMessage(param1);
      }
      
      public function deserializeAs_JobExperienceOtherPlayerUpdateMessage(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
         this._playerIdFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_JobExperienceOtherPlayerUpdateMessage(param1);
      }
      
      public function deserializeAsyncAs_JobExperienceOtherPlayerUpdateMessage(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._playerIdFunc);
      }
      
      private function _playerIdFunc(param1:ICustomDataInput) : void
      {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.playerId + ") on element of JobExperienceOtherPlayerUpdateMessage.playerId.");
         }
      }
   }
}
