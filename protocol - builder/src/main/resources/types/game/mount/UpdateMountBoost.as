package com.ankamagames.dofus.network.types.game.mount
{
   import com.ankamagames.jerakine.network.INetworkType;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   public class UpdateMountBoost extends Object implements INetworkType
   {
      
      public static const protocolId:uint = 356;
       
      public var type:uint = 0;
      
      public function UpdateMountBoost()
      {
         super();
      }
      
      public function getTypeId() : uint
      {
         return 356;
      }
      
      public function initUpdateMountBoost(param1:uint = 0) : UpdateMountBoost
      {
         this.type = param1;
         return this;
      }
      
      public function reset() : void
      {
         this.type = 0;
      }
      
      public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_UpdateMountBoost(param1);
      }
      
      public function serializeAs_UpdateMountBoost(param1:ICustomDataOutput) : void
      {
         param1.writeByte(this.type);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_UpdateMountBoost(param1);
      }
      
      public function deserializeAs_UpdateMountBoost(param1:ICustomDataInput) : void
      {
         this._typeFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_UpdateMountBoost(param1);
      }
      
      public function deserializeAsyncAs_UpdateMountBoost(param1:FuncTree) : void
      {
         param1.addChild(this._typeFunc);
      }
      
      private function _typeFunc(param1:ICustomDataInput) : void
      {
         this.type = param1.readByte();
         if(this.type < 0)
         {
            throw new Error("Forbidden value (" + this.type + ") on element of UpdateMountBoost.type.");
         }
      }
   }
}
