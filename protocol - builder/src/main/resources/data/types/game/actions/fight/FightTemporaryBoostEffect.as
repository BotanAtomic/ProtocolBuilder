package data.types.game.actions.fight
{
   import com.ankamagames.jerakine.network.INetworkType;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class FightTemporaryBoostEffect extends AbstractFightDispellableEffect implements INetworkType
   {
      
      public static const protocolId:uint = 209;
       
      public var delta:int = 0;
      
      public function FightTemporaryBoostEffect()
      {
         super();
      }
      
      override public function getTypeId() : uint
      {
         return 209;
      }
      
      public function initFightTemporaryBoostEffect(param1:uint = 0, param2:Number = 0, param3:int = 0, param4:uint = 1, param5:uint = 0, param6:uint = 0, param7:uint = 0, param8:int = 0) : FightTemporaryBoostEffect
      {
         super.initAbstractFightDispellableEffect(param1,param2,param3,param4,param5,param6,param7);
         this.delta = param8;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
         this.delta = 0;
      }
      
      override public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_FightTemporaryBoostEffect(param1);
      }
      
      public function serializeAs_FightTemporaryBoostEffect(param1:ICustomDataOutput) : void
      {
         super.serializeAs_AbstractFightDispellableEffect(param1);
         param1.writeShort(this.delta);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_FightTemporaryBoostEffect(param1);
      }
      
      public function deserializeAs_FightTemporaryBoostEffect(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
         this._deltaFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_FightTemporaryBoostEffect(param1);
      }
      
      public function deserializeAsyncAs_FightTemporaryBoostEffect(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._deltaFunc);
      }
      
      private function _deltaFunc(param1:ICustomDataInput) : void
      {
         this.delta = param1.readShort();
      }
   }
}
