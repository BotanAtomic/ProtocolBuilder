package package com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PortalInformation extends Object implements INetworkType {

    private int protocolId = 466;
    private int portalId = 0;
    private int areaId = 0;


    public int getTypeId() {
         return 466;
    }

    public PortalInformation initPortalInformation(int param1,int  param2) {
         this.portalId = param1;
         this.areaId = param2;
         return this;
    }

    public void reset() {
         this.portalId = 0;
         this.areaId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PortalInformation(param1);
    }

    public void serializeAs_PortalInformation(ICustomDataOutput param1) {
         param1.writeInt(this.portalId);
         param1.writeShort(this.areaId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PortalInformation(param1);
    }

    public void deserializeAs_PortalInformation(ICustomDataInput param1) {
         this._portalIdFunc(param1);
         this._areaIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PortalInformation(param1);
    }

    public void deserializeAsyncAs_PortalInformation(FuncTree param1) {
         param1.addChild(this._portalIdFunc);
         param1.addChild(this._areaIdFunc);
    }

    private void _portalIdFunc(ICustomDataInput param1) {
         this.portalId = param1.readInt();
    }

    private void _areaIdFunc(ICustomDataInput param1) {
         this.areaId = param1.readShort();
    }

}