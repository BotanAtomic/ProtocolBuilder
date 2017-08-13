package com.ankamagames.dofus.network.types.game.shortcut
{
   import com.ankamagames.jerakine.network.INetworkType;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   public class ShortcutObjectPreset extends ShortcutObject implements INetworkType
   {
      
      public static const protocolId:uint = 370;
       
      public var presetId:uint = 0;
      
      public function ShortcutObjectPreset()
      {
         super();
      }
      
      override public function getTypeId() : uint
      {
         return 370;
      }
      
      public function initShortcutObjectPreset(param1:uint = 0, param2:uint = 0) : ShortcutObjectPreset
      {
         super.initShortcutObject(param1);
         this.presetId = param2;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
         this.presetId = 0;
      }
      
      override public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_ShortcutObjectPreset(param1);
      }
      
      public function serializeAs_ShortcutObjectPreset(param1:ICustomDataOutput) : void
      {
         super.serializeAs_ShortcutObject(param1);
         if(this.presetId < 0)
         {
            throw new Error("Forbidden value (" + this.presetId + ") on element presetId.");
         }
         param1.writeByte(this.presetId);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_ShortcutObjectPreset(param1);
      }
      
      public function deserializeAs_ShortcutObjectPreset(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
         this._presetIdFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_ShortcutObjectPreset(param1);
      }
      
      public function deserializeAsyncAs_ShortcutObjectPreset(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._presetIdFunc);
      }
      
      private function _presetIdFunc(param1:ICustomDataInput) : void
      {
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Error("Forbidden value (" + this.presetId + ") on element of ShortcutObjectPreset.presetId.");
         }
      }
   }
}
