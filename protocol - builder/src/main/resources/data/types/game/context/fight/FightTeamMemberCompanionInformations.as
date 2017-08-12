package data.types.game.context.fight
{
   import com.ankamagames.jerakine.network.INetworkType;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   public class FightTeamMemberCompanionInformations extends FightTeamMemberInformations implements INetworkType
   {
      
      public static const protocolId:uint = 451;
       
      public var companionId:uint = 0;
      
      public var level:uint = 0;
      
      public var masterId:Number = 0;
      
      public function FightTeamMemberCompanionInformations()
      {
         super();
      }
      
      override public function getTypeId() : uint
      {
         return 451;
      }
      
      public function initFightTeamMemberCompanionInformations(param1:Number = 0, param2:uint = 0, param3:uint = 0, param4:Number = 0) : FightTeamMemberCompanionInformations
      {
         super.initFightTeamMemberInformations(param1);
         this.companionId = param2;
         this.level = param3;
         this.masterId = param4;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
         this.companionId = 0;
         this.level = 0;
         this.masterId = 0;
      }
      
      override public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_FightTeamMemberCompanionInformations(param1);
      }
      
      public function serializeAs_FightTeamMemberCompanionInformations(param1:ICustomDataOutput) : void
      {
         super.serializeAs_FightTeamMemberInformations(param1);
         if(this.companionId < 0)
         {
            throw new Error("Forbidden value (" + this.companionId + ") on element companionId.");
         }
         param1.writeByte(this.companionId);
         if(this.level < 1 || this.level > 200)
         {
            throw new Error("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
         if(this.masterId < -9.007199254740992E15 || this.masterId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.masterId + ") on element masterId.");
         }
         param1.writeDouble(this.masterId);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_FightTeamMemberCompanionInformations(param1);
      }
      
      public function deserializeAs_FightTeamMemberCompanionInformations(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
         this._companionIdFunc(param1);
         this._levelFunc(param1);
         this._masterIdFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_FightTeamMemberCompanionInformations(param1);
      }
      
      public function deserializeAsyncAs_FightTeamMemberCompanionInformations(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._companionIdFunc);
         param1.addChild(this._levelFunc);
         param1.addChild(this._masterIdFunc);
      }
      
      private function _companionIdFunc(param1:ICustomDataInput) : void
      {
         this.companionId = param1.readByte();
         if(this.companionId < 0)
         {
            throw new Error("Forbidden value (" + this.companionId + ") on element of FightTeamMemberCompanionInformations.companionId.");
         }
      }
      
      private function _levelFunc(param1:ICustomDataInput) : void
      {
         this.level = param1.readUnsignedByte();
         if(this.level < 1 || this.level > 200)
         {
            throw new Error("Forbidden value (" + this.level + ") on element of FightTeamMemberCompanionInformations.level.");
         }
      }
      
      private function _masterIdFunc(param1:ICustomDataInput) : void
      {
         this.masterId = param1.readDouble();
         if(this.masterId < -9.007199254740992E15 || this.masterId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.masterId + ") on element of FightTeamMemberCompanionInformations.masterId.");
         }
      }
   }
}
