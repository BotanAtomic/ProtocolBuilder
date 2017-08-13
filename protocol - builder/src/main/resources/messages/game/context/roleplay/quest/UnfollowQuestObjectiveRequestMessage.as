package com.ankamagames.dofus.network.messages.game.context.roleplay.quest
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class UnfollowQuestObjectiveRequestMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6723;
       
      private var _isInitialized:Boolean = false;
      
      public var questId:uint = 0;
      
      public var objectiveId:int = 0;
      
      public function UnfollowQuestObjectiveRequestMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6723;
      }
      
      public function initUnfollowQuestObjectiveRequestMessage(param1:uint = 0, param2:int = 0) : UnfollowQuestObjectiveRequestMessage
      {
         this.questId = param1;
         this.objectiveId = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.questId = 0;
         this.objectiveId = 0;
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
         this.serializeAs_UnfollowQuestObjectiveRequestMessage(param1);
      }
      
      public function serializeAs_UnfollowQuestObjectiveRequestMessage(param1:ICustomDataOutput) : void
      {
         if(this.questId < 0)
         {
            throw new Error("Forbidden value (" + this.questId + ") on element questId.");
         }
         param1.writeVarShort(this.questId);
         param1.writeShort(this.objectiveId);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_UnfollowQuestObjectiveRequestMessage(param1);
      }
      
      public function deserializeAs_UnfollowQuestObjectiveRequestMessage(param1:ICustomDataInput) : void
      {
         this._questIdFunc(param1);
         this._objectiveIdFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_UnfollowQuestObjectiveRequestMessage(param1);
      }
      
      public function deserializeAsyncAs_UnfollowQuestObjectiveRequestMessage(param1:FuncTree) : void
      {
         param1.addChild(this._questIdFunc);
         param1.addChild(this._objectiveIdFunc);
      }
      
      private function _questIdFunc(param1:ICustomDataInput) : void
      {
         this.questId = param1.readVarUhShort();
         if(this.questId < 0)
         {
            throw new Error("Forbidden value (" + this.questId + ") on element of UnfollowQuestObjectiveRequestMessage.questId.");
         }
      }
      
      private function _objectiveIdFunc(param1:ICustomDataInput) : void
      {
         this.objectiveId = param1.readShort();
      }
   }
}
