package package com.ankamagames.dofus.network.types.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.fight.ProtectedEntityWaitingForHelpInfo;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorWaitingForHelpInformations extends TaxCollectorComplementaryInformations implements INetworkType {

    private int protocolId = 447;
    private ProtectedEntityWaitingForHelpInfo waitingForHelpInfo = ;
    private FuncTree _waitingForHelpInfotree = ;


    public int getTypeId() {
         return 447;
    }

    public TaxCollectorWaitingForHelpInformations initTaxCollectorWaitingForHelpInformations(ProtectedEntityWaitingForHelpInfo param1) {
         this.waitingForHelpInfo = param1;
         return this;
    }

    public void reset() {
         this.waitingForHelpInfo = new ProtectedEntityWaitingForHelpInfo();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_TaxCollectorWaitingForHelpInformations(param1);
    }

    public void serializeAs_TaxCollectorWaitingForHelpInformations(ICustomDataOutput param1) {
         super.serializeAs_TaxCollectorComplementaryInformations(param1);
         this.waitingForHelpInfo.serializeAs_ProtectedEntityWaitingForHelpInfo(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TaxCollectorWaitingForHelpInformations(param1);
    }

    public void deserializeAs_TaxCollectorWaitingForHelpInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.waitingForHelpInfo = new ProtectedEntityWaitingForHelpInfo();
         this.waitingForHelpInfo.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TaxCollectorWaitingForHelpInformations(param1);
    }

    public void deserializeAsyncAs_TaxCollectorWaitingForHelpInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._waitingForHelpInfotree = param1.addChild(this._waitingForHelpInfotreeFunc);
    }

    private void _waitingForHelpInfotreeFunc(ICustomDataInput param1) {
         this.waitingForHelpInfo = new ProtectedEntityWaitingForHelpInfo();
         this.waitingForHelpInfo.deserializeAsync(this._waitingForHelpInfotree);
    }

}